# Copilot Instructions for Code-Gym Workspace

## Overview
This workspace is a collection of lesson folders for basic programming, primarily using HTML and JavaScript. Each lesson contains exercises, sample code, and supporting files. The structure is designed for educational purposes, focusing on hands-on practice with small, self-contained files.

## Project Structure
- Each `Lession X/` folder contains:
  - HTML files for exercises (e.g., `bai1.html`, `bai2.html`)
  - Subfolders for grouped exercises (e.g., `luyện for/`, `luyện tập vòng lặp 1/`)
  - Occasional `.js` files for JavaScript logic
  - Supporting assets (images, docs)
- No build system, package manager, or test framework is present. All code runs directly in the browser.

## Key Patterns
- Exercise files are named descriptively (e.g., `soNguyenTo.html`, `bangCuuChuong.html`).
- JavaScript is typically embedded in `<script>` tags within HTML files.
- Each exercise is self-contained; there is no cross-file/module dependency.
- Vietnamese is used for file/folder names and comments.

## Developer Workflow
- Open HTML files directly in a browser to view and test exercises.
- Edit JavaScript within the `<script>` tag of each HTML file.
- No build or test commands are required.
- No external libraries or frameworks are used unless explicitly included in an exercise file.

## Conventions
- Keep each exercise independent; do not introduce shared state or modules.
- Use clear, simple variable names and comments (preferably in Vietnamese for consistency).
- When adding new exercises, follow the existing naming and folder structure.

## Examples
- See `Lession 10/luyện tập vòng lặp 1/b5.html` for a Fibonacci sum example.
- See `Lession 7/doi-tien/chuyen-doi-tien-te.js` for a simple JS logic file.

## Integration Points
- None: all code is standalone and browser-based.

---
For any automation or AI agent, focus on generating or editing single-file HTML/JS exercises, following the above conventions. Do not introduce build tools, package managers, or external dependencies unless explicitly requested.
