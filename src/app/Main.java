package app;
import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final String CARGO = "laboratory equipment";
    private static final String DESTINATION = "Aktau warehouse";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String deliveryMode = readChoice(scanner, "Enter delivery mode (ROAD or SEA): ");
        String uiPlatform = readChoice(scanner, "Enter UI platform (WINDOWS or MACOS): ");
        Logistics logistics;
        GUIFactory guiFactory;
        try {
            requireValue("Delivery mode", deliveryMode);
            requireValue("UI platform", uiPlatform);
            logistics = createLogistics(deliveryMode);
            guiFactory = createGuiFactory(uiPlatform);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Delivery mode: " + deliveryMode);
        System.out.println("UI platform: " + uiPlatform);
        new DeliveryApplication(guiFactory, logistics).run(CARGO, DESTINATION);
    }
    private static String readChoice(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            return "";
        }
        return scanner.nextLine().trim().toUpperCase(Locale.ROOT);
    }
    private static void requireValue(String name, String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(name + " is required.");
        }
    }
    private static Logistics createLogistics(String deliveryMode) {
        return switch (deliveryMode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> throw new IllegalArgumentException(
                    "Unsupported delivery mode: " + deliveryMode + ". Supported: ROAD, SEA.");
        };
    }
    private static GUIFactory createGuiFactory(String uiPlatform) {
        return switch (uiPlatform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> throw new IllegalArgumentException(
                    "Unsupported UI platform: " + uiPlatform + ". Supported: WINDOWS, MACOS.");
        };
    }
}
