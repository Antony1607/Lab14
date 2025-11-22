package com.tecsup.labs;

/**
 * Clase de demostración para ejecutar el servicio.
 */
public final class Main {

    /**
     * Constructor privado para evitar instanciación.
     */
    private Main() {
    }

    /**
     * Método principal de ejecución.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(final String[] args) {
        UserRegistrationService service =
                new UserRegistrationService();

        service.registerUser("juan", "123", "juan@correo");
        System.out.println(service.getLastErrorMessage());

        service.registerUser(null, "12345678", "correo-sin-arroba");
        System.out.println(service.getLastErrorMessage());

        service.registerUser("error", "12345678", "error@correo.com");
        System.out.println(service.getLastErrorMessage());
    }
}

