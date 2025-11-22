package com.tecsup.labs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para UserRegistrationService.
 */
public class UserRegistrationServiceTest {

    /**
     * Verifica que un registro válido sea exitoso.
     */
    @Test
    public void testRegistroUsuarioCorrecto() {
        UserRegistrationService service = new UserRegistrationService();

        boolean resultado = service.registerUser(
                "antonio", "12345678", "antonio@test.com");

        assertTrue("El registro debería ser exitoso", resultado);
    }

    /**
     * Verifica que username null falle correctamente.
     */
    @Test
    public void testUsernameNulo() {
        UserRegistrationService service = new UserRegistrationService();

        boolean resultado = service.registerUser(
                null, "12345678", "correo@test.com");

        assertFalse("Debe fallar si username es null", resultado);
        assertEquals("El nombre de usuario está vacío o es null.",
                service.getLastErrorMessage());
    }

    /**
     * Verifica que una contraseña demasiado corta falle.
     */
    @Test
    public void testPasswordMuyCorta() {
        UserRegistrationService service = new UserRegistrationService();

        boolean resultado = service.registerUser(
                "juan", "123", "juan@test.com");

        assertFalse("Debe fallar si la contraseña es corta", resultado);
        assertEquals("La contraseña es muy corta.",
                service.getLastErrorMessage());
    }

    /**
     * Verifica que un correo inválido falle la validación.
     */
    @Test
    public void testEmailInvalido() {
        UserRegistrationService service = new UserRegistrationService();

        boolean resultado = service.registerUser(
                "maria", "12345678", "correoSinArroba");

        assertFalse("Debe fallar si el correo es inválido", resultado);
        assertEquals("El correo electrónico no es válido.",
                service.getLastErrorMessage());
    }

    /**
     * Verifica que un error al guardar el usuario genere excepción controlada.
     */
    @Test
    public void testExcepcionAlGuardarUsuario() {
        UserRegistrationService service = new UserRegistrationService();

        boolean resultado = service.registerUser(
                "error", "12345678", "error@test.com");

        assertFalse("Debe fallar cuando saveUser lanza excepción",
                resultado);

        assertEquals("Error desconocido al guardar el usuario.",
                service.getLastErrorMessage());
    }
}
