/* Anubis service worker — offline-capable app shell */
const CACHE = 'anubis-v1';
const ASSETS = ['./', './index.html', './manifest.webmanifest'];
const ICO = ['icons/icon-192.png','icons/icon-512.png','icons/icon-180.png','icons/icon-maskable-512.png'];

self.addEventListener('install', (e) => {
  e.waitUntil(
    caches.open(CACHE)
      .then((c) => c.addAll(ASSETS.concat(ICO)))
      .catch(() => null)
      .then(() => self.skipWaiting())
  );
});

self.addEventListener('activate', (e) => {
  e.waitUntil(
    caches.keys()
      .then((keys) => Promise.all(keys.filter((k) => k !== CACHE).map((k) => caches.delete(k))))
      .then(() => self.clients.claim())
  );
});

self.addEventListener('fetch', (e) => {
  const req = e.request;
  if (req.method !== 'GET') return;

  // Only handle same-origin (APP) navigation/resource requests; never cache cross-origin.
  const url = new URL(req.url);
  if (url.origin !== self.location.origin) return;

  // Simple offline-first with stale-while-revalidate refresh.
  e.respondWith(
    caches.match(req).then((cached) => {
      const network = fetch(req)
        .then((res) => {
          // Cache successful, basic, same-origin responses.
          if (res && res.status === 200 && res.type === 'basic') {
            const clone = res.clone();
            caches.open(CACHE).then((c) => c.put(req, clone));
          }
          return res;
        })
        .catch(() => cached);
      return cached || network;
    })
  );
});
