# Factory Method and Abstract Factory Assignment

## Project Description

This Java project demonstrates the implementation of two creational design patterns:

- Factory Method
- Abstract Factory

The application simulates a delivery system where the user can choose a delivery mode and a UI platform.

The delivery mode can be ROAD or SEA.
The UI platform can be WINDOWS or MACOS.

## Design Patterns

### Factory Method

The Factory Method pattern is used to create different types of transport.

- `Transport` - Product interface
- `Truck` and `Ship` - Concrete Products
- `Logistics` - Creator
- `RoadLogistics` and `SeaLogistics` - Concrete Creators
- `createTransport()` - Factory Method

ROAD delivery creates a Truck, while SEA delivery creates a Ship.

### Abstract Factory

The Abstract Factory pattern is used to create families of UI components.

- `Button` and `Checkbox` - Abstract Products
- `WindowsButton` and `WindowsCheckbox` - Windows products
- `MacOSButton` and `MacOSCheckbox` - macOS products
- `GUIFactory` - Abstract Factory
- `WindowsFactory` and `MacOSFactory` - Concrete Factories

Each concrete factory creates a matching Button and Checkbox for its platform.

## Project Structure

```text
src/
├── factorymethod/
│   ├── Transport.java
│   ├── Truck.java
│   ├── Ship.java
│   ├── Logistics.java
│   ├── RoadLogistics.java
│   └── SeaLogistics.java
│
├── abstractfactory/
│   ├── Button.java
│   ├── Checkbox.java
│   ├── WindowsButton.java
│   ├── WindowsCheckbox.java
│   ├── MacOSButton.java
│   ├── MacOSCheckbox.java
│   ├── GUIFactory.java
│   ├── WindowsFactory.java
│   └── MacOSFactory.java
│
└── app/
    ├── DeliveryApplication.java
    └── Main.java
```

## Requirements

- Java JDK 17
- IntelliJ IDEA or another Java IDE

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 17 is selected.
3. Open `src/app/Main.java`.
4. Run the `main()` method.
5. Enter the delivery mode when prompted.
6. Enter the UI platform when prompted.

## Supported Input

Delivery modes:

```text
ROAD
SEA
```

UI platforms:

```text
WINDOWS
MACOS
```

The program also validates missing or unsupported input.

## Example Run

```text
Enter delivery mode (ROAD or SEA): ROAD
Enter UI platform (WINDOWS or MACOS): WINDOWS
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse
```

## Supported Combinations

The application supports four combinations:

- ROAD + WINDOWS
- SEA + WINDOWS
- ROAD + MACOS
- SEA + MACOS

The delivery mode and UI platform can be selected independently.