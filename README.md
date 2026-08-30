# Anubis — The Viewer of the Truth Inside Humans

A science-grounded **people profiler & safety guide**. Add a person → answer a
short questionnaire → Anubis reads them (honesty, empathy, dark traits, etc.) and
shows a **filled human icon, a confidence %**, **what to observe**, and a
**relationship-aware report** with a scientific personality category.

Built for young / naive / honest users who want to read people clearly before
they trust them.

## Features
- Add a person (basic facts → questionnaire → report)
- 66-question flow split into **45 Essentials + 21 optional deeper** questions
- Per-person **confidence score** + "what to observe" pointers
- **Relationship-aware** advice (friend vs. partner vs. coworker…)
- **Your Profile** — self-assessment (show account details, editable)
- **People** tab — list, re-open, redo an evaluation, **sort (dropdown)**
- **Compare** — similarity between you and a person
- Per-user **password accounts** (PBKDF2-hashed, local) + lock
- **Offline PWA** — installable on desktop, Android, and iOS
- **Firebase** backend for cloud data + category-ratio analytics *(optional config — see below)*

## Web
The app is a single static file: `index.html` + `manifest.webmanifest` + `sw.js`
+ `icons/`. Deploy to any static host (Netlify, Vercel, GitHub Pages, Firebase
Hosting) to get a permanent URL. It installs as an app (desktop / Android / iOS).

Run locally:
```bash
python3 -m http.server 8080
# open http://localhost:8080
```

## Android
The Android app is a **Capacitor** WebView build. Source lives in `capacitor/`.
Build & sign with the release keystore (see `capacitor/keystore/` notes in
`INSTALL_AND_BUILD.md`). Rebuild:
```bash
./build-apk.sh
```

## Firebase setup (enables cloud data + analytics)
1. Create a Firebase project at <https://console.firebase.google.com>.
2. **Build → Authentication** → enable **Email/Password**.
3. **Build → Firestore Database** → create database (**Production mode**).
4. **Project settings ⚙ → General → Your apps → Web `</>` → register**.
5. Copy the `const firebaseConfig = { ... }` block into **`firebase-config.js`**.

The app reads that file and uploads an **anonymized category count** so the admin
dashboard can chart the ratio of each "kind"/personality type across all users.

> Firebase is **optional** — without `firebase-config.js` the app runs fully
> offline, storing everything in `localStorage` on the device.

## Privacy
Users agree to the **Terms & Privacy Policy** (in `PRIVACY.md`) on first run
before any data is sent. Profiles of people a user profiles are stored per-account.
See `PRIVACY.md` for what's collected and how to delete it.

## Credits / Version
`Anubis` · Developed by **Modjtaba M. Mansouri** · v3.8.5 · 2026
