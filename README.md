# Dynamic Dashboard (Jetpack Compose)

This project implements a dynamic dashboard screen in Android using **Jetpack Compose**, where widgets are rendered based on backend-provided metadata. The focus of the assignment is on Compose fundamentals, MVVM-style architecture, and correct state management for repeated widgets.

---

## Overview

The backend provides a list of widget metadata in the following format:

```json
{
  "type": "banner" | "list",
  "instanceId": "string"
}
```

The dashboard renders widgets vertically in the same order as the metadata. Each widget decides its own internal layout based on its type.

---

## Architecture

The project follows an **MVVM-style architecture**:

* **DashboardViewModel**

  * Loads widget metadata from a fake backend
  * Exposes the data required to render the dashboard

* **Composable UI**

  * Renders widgets declaratively using Jetpack Compose
  * Contains no business logic or data-fetching code

---

## Widget Identity & State Management

Each widget is identified using the backend-provided `instanceId`.

* `instanceId` is used as the key when rendering widgets in Compose
* For stateful widgets (List widgets), `instanceId` is also used as the ViewModel key
* This ensures multiple instances of the same widget type can appear safely without sharing state

---

## Banner Widget

* Banner widgets are stateless and fully driven by data
* Each banner widget displays one or more banners horizontally using a `LazyRow`
* Banner content is generated using a fake data source based on `instanceId`

---

## List Widget

* Each list widget fetches its own data independently using a fake API
* Loading, success, and error states are handled inside the widget’s ViewModel
* A separate ViewModel is created per list widget instance using a custom `ViewModelFactory`

---

## UI Decisions

* The dashboard uses a single vertical `LazyColumn`
* Banner widgets scroll horizontally, while list widgets render non-scrollable vertical content
* This avoids nested vertical scrolling and keeps the UI predictable and scalable

---

## What I Would Improve Next

* Add dependency injection for ViewModels
* Improve error handling and retry support
* Add UI and ViewModel tests
* Replace fake APIs with real network calls

---

## Summary

This project demonstrates dynamic UI rendering using Jetpack Compose, clean separation of concerns with MVVM, and safe state handling for repeated widget instances.
