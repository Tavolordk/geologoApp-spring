function toggleForm() {
    const signInButton = document.getElementById("signInButton");
    const formulario = document.getElementById("miFormulario");
    const botonPost = document.querySelector('.btn-register');
    // Cambiar el texto del botón
    signInButton.textContent = signInButton.textContent === "Sign-in" ? "Login" : "Sign-in";
    botonPost.textContent = botonPost.textContent === 'Registrarse'?'Iniciar Sesión':'Registrarse';

    // Cambiar las clases del contenedor
    const container = signInButton.closest(".seleccion-login-sign");
    container.classList.toggle("justify-content-start");
    container.classList.toggle("justify-content-end");

    // Ocultar/mostrar campos de nombre, apellido paterno y apellido materno
    const nombreInput = formulario.querySelector(".div-nombre");
    const apInput = formulario.querySelector(".div-Ap");
    const amInput = formulario.querySelector(".div-Am");

    nombreInput.style.display = nombreInput.style.display === "none" ? "block" : "none";
    apInput.style.display = apInput.style.display === "none" ? "block" : "none";
    amInput.style.display = amInput.style.display === "none" ? "block" : "none";
  }