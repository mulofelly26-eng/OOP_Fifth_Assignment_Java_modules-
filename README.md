# Uganda National Services System

A menu-driven government services application written in **Java 17** with the **Java Platform Module System (JPMS)**. The user picks a service from a `JOptionPane` window, and each service lives in its own module that exposes only its public API.

## Features

| # | Service | What it does |
|---|---------|--------------|
| 1 | National ID | Register a citizen (NIN + name) or list all registered citizens |
| 2 | Tax | Calculate tax on an amount (flat 15%) |
| 3 | Passport | Apply for a passport, the applicant's NIN is verified first |
| 4 | Business registration | Register a business, the owner's NIN is verified first |

At startup the program also prints a feature overview in the console by calling the real classes of every module.

## Project structure

```
OOP_Fifth_Assignment_Java_modules
|-- App_Module
|   `-- src
|       |-- app/Main.java
|       `-- module-info.java
|-- BusinessReg_Module
|   `-- src
|       |-- Businessreg/BusinessService.java
|       `-- module-info.java
|-- NationalId_Service
|   `-- src
|       |-- api/NationalIdProvider.java
|       |-- api/NationalIdService.java
|       |-- internal/NationalIdServiceImpl.java
|       `-- module-info.java
|-- Passport_Module
|   `-- src
|       |-- passport/PassportProvider.java
|       `-- module-info.java
`-- Tax_Module
    `-- src
        |-- tax_api/TaxProvider.java
        |-- tax_api/TaxService.java
        |-- tax_internal/TaxServiceImpl.java
        `-- module-info.java
```

## Modules and dependencies

| Module | Exports | Requires |
|--------|---------|----------|
| `nationalid` | `api` | none |
| `tax` | `tax_api` | none |
| `passport` | `passport` | `nationalid` |
| `businessreg` | `Businessreg` | `nationalid` |
| `app` | none | `nationalid`, `tax`, `passport`, `businessreg`, `java.desktop` |

`passport` and `businessreg` depend on `nationalid`, and `app` depends on all of them.

## Design highlights

- **Interfaces hide the implementation.** Other modules use `NationalIdService` and `TaxService`. The `internal` and `tax_internal` packages are not exported.
- **Shared database through a singleton.** `NationalIdProvider` returns one shared `NationalIdServiceImpl`, so a citizen registered in service 1 is also found by the passport and business services.
- **Provider classes** (`NationalIdProvider`, `TaxProvider`) are the only entry points into each module.
- **Data storage:** citizens are stored in a `HashMap<String, String>` (NIN as key, full name as value).

## Pre-loaded citizens

These NINs are always verified:

| NIN | Name |
|-----|------|
| `CM18749` | Nahato Sarah |
| `CM17623` | Okello David |

## Requirements

- JDK 17
- IntelliJ IDEA (the project is built as five modules in one IntelliJ project)

## How to run

1. Clone the repository:
```bash
   git clone <your-repository-url>
```
2. Open the project in IntelliJ IDEA and make sure all five modules are loaded.
3. Run `Main` in `App_Module/src/app/Main.java`.
4. Enter a service number in the dialog window (1 to 4) and follow the prompts.

## Sample console output

```
===== SYSTEM FEATURES =====
1 : National ID, registered citizens:
CM18749 => Nahato Sarah
CM17623 => Okello David

2 : Tax, tax on 1000000 = 150000.0
3 : Passport, Passport application accepted Nahato Sarah
4 : Business, Business Kampala Traders registered
```

## Branches

The code is split into one branch per module, each with two commits:

| Branch | Content |
|--------|---------|
| `feature/national-id-module` | National ID interface, implementation, provider and module descriptor |
| `feature/tax-module` | Tax interface, implementation, provider and module descriptor |
| `feature/passport-module` | Passport service with NIN verification |
| `feature/business-registration-module` | Business registration with owner verification |
| `feature/app-ui-module` | `JOptionPane` menu and startup feature overview |

## Known limitations

- Data is stored in memory only, so registered citizens are lost when the program closes.
- Clicking **Cancel** in an input dialog is not handled in every menu step.
- Entering a non-numeric amount in the tax service throws a `NumberFormatException`.

## What I learned

- Building a simple user interface with `javax.swing.JOptionPane`
- Splitting a system into modules in IntelliJ with `requires` and `exports`
- Using interfaces to separate a contract from its implementation
- Storing data as key and value with `Map<>` (`HashMap`)
- Building text efficiently with `StringBuilder`

## Author

Mulo
