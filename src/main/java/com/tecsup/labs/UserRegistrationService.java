package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar el registro de usuarios.
 */
public class UserRegistrationService {

    /**
     * Último mensaje de error registrado.
     */
    private String lastErrorMessage = "";

    /**
     * Lista de usuarios registrados.
     */
    private List<String> users = new ArrayList<>();

    /**
     * Longitud mínima permitida para la contraseña.
     */
    private static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Constructor del servicio.
     */
    public UserRegistrationService() {
        System.out.println("Constructor llamado");
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @param email    Correo electrónico.
     * @return true si el usuario fue registrado, false en caso contrario.
     */
    public boolean registerUser(final String username,
            final String password, final String email) {

        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage =
                    "El nombre de usuario está vacío o es null.";
            return false;
        }

        if (password == null) {
            lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }

        if (email == null || !email.contains("@")
                || !email.contains(".")) {
            lastErrorMessage = "El correo electrónico no es válido.";
            return false;
        }

        try {
            saveUser(username, password, email);
        } catch (Exception e) {
            lastErrorMessage =
                    "Error desconocido al guardar el usuario.";
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    /**
     * Guarda un usuario en memoria.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @param email    Correo electrónico.
     * @throws Exception Si ocurre un problema durante el guardado.
     */
    private void saveUser(final String username,
            final String password, final String email)
            throws Exception {

        users.add(username);

        if ("error".equals(username)) {
            throw new Exception("Nombre de usuario no permitido.");
        }
    }

    /**
     * Retorna el último mensaje de error.
     *
     * @return Mensaje de error.
     */
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    /**
     * Calcula la longitud de una cadena.
     *
     * @param s Cadena a analizar.
     * @return Longitud, o -1 si es null.
     */
    public int calculateLength(final String s) {
        if (s == null) {
            return -1;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }

        return builder.length();
    }
}
