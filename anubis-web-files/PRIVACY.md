# Anubis — Privacy Policy & Terms of Use

*Last updated: 2026-08-30*

Anubis ("the app") is a people-profiling and safety guidance tool developed by
**Modjtaba M. Mansouri**. By downloading, installing, or using Anubis you agree to
these Terms and this Privacy Policy. **You must agree before the app uploads any
data** (a one-time "I agree" step is shown on first run).

---

## 1. What data is stored and where

Anubis stores data **in the cloud (Firebase)** and, when no network/cloud is
configured, **on your device (localStorage)**.

| Data | Purpose | Where |
|---|---|---|
| Account (name, birth date, gender, hashed password) | Sign in & keep your saves private per-account | Firebase Auth + Firestore / localStorage |
| People you profile (name, relation, questionnaire answers, resulting read, category) | Show reports, profile reads, comparisons | Firestore / localStorage |
| Your own profile answers | Self-knowledge read | Firestore / localStorage |
| **Anonymized category counts** | **Aggregate analytics** — chart the ratio of each personality "kind" across all users | Firestore (no names) |

## 2. Consent
- By using Anubis you **agree to these Terms and this Privacy Policy**.
- The app shows a one-time consent screen on first launch. If you decline, the app
  does **not** upload anything and runs fully offline on your device.

## 3. What we **do not** collect
- We do **not** collect your real identity, payment info, precise location, contacts,
  or call/text data.
- The aggregated category analytics are **number-only** (counts), not tied to names.

## 4. Your rights
- **Delete:** you can delete any profile and/or your whole account from within the app.
- **Export:** your data is stored in a readable (JSON) format on Firebase / your device.
- To stop all uploads, disable the cloud connection; the app continues to work offline.

## 5. Security
- Passwords are hashed (PBKDF2-SHA256) and never stored in plain text.
- Data storage is protected by **Firebase Authentication** and **Firestore Security
  Rules** (least-privilege: each account can only read/write its own data).

## 6. Children
Anubis is intended for users who are at least 13 years old (or the minimum age in
your country). Minors should use Anubis with a parent/guardian's consent.

## 7. Analytics ("kind people")
The app may send an **anonymized aggregate count** (how many profiled people fall
into each personality category) to the developer so the developer can display the
**ratio of each "kind"** and optionally track **presence after 6–12 months**. This
report contains **no names or personal data** — only numbers.

## 8. Contact
Questions about this policy or your data: contact the developer via the repository
issue tracker.

---
**By using Anubis you acknowledge that you have read and agree to this Privacy
Policy and Terms of Use.**
