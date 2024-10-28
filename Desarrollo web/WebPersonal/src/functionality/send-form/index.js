function submitFormData(formId) {
    const contactForm = document.getElementById(formId);

    contactForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const formData = {
            fullName: this.fullName.value,
            email: this.email.value,
            userType: this.userType.value,
            message: this.message.value
        };

        console.log('Form submitted:', formData);
        alert('Formulario enviado con éxito!');

        this.reset();
    });
}


export { submitFormData };
