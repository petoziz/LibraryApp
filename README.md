# Library App

Jednoduchá konzolová aplikácia na správu knižnice napísaná v čistej **Java SE**.  
A simple console application for managing a personal book library written in **pure Java SE**.

---

## Funkcie / Features

- ✅ Pridať novú knihu / Add a new book
- ✅ Zmazať knihu / Delete a book
- ✅ Zobraziť všetky knihy v prehľadnej tabuľke / Display all books in a formatted table
- ✅ Požičať knihu / Borrow a book
- ✅ Vrátiť knihu / Return a book
- ✅ Importovať knihy zo súboru / Import books from a `.txt` file
- 💾 Automatické ukladanie a načítanie údajov zo súboru `library.txt`

---

## Použité technológie / Technologies used

- Java 17+
- IntelliJ IDEA (alebo iné IDE)
- Pure Java SE (no external libraries)

---

## Formát import súboru / Import file format

Každý riadok v súbore musí mať formát:


**Príklad:**

The Hobbit;J.R.R. Tolkien;1937
1984;George Orwell;1949


---

## Spustenie aplikácie / How to run

1. Otvor projekt v IntelliJ IDEA
2. Spusti triedu `Main.java`
3. Použi menu v konzole pre interakciu

---

## Štruktúra projektu / Project structure

com.library
├── Book.java // model knihy / book entity
├── Library.java // logika knižnice / core logic
└── Main.java // hlavná trieda / main entry point


---

## Súbory

- `library.txt` – hlavný úložný súbor knižnice
- `import.txt` – voliteľný súbor na hromadný import kníh

---

## Licencia / License

Tento projekt je určený na učenie a osobné použitie.  
This project is intended for learning and personal use.


