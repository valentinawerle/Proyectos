// Stack data
const languages = [
    { name: 'Python', icon: '/python-logo.png' },
    { name: 'Java', icon: '/java-logo.png' },
    { name: 'C', icon: '/c-logo.png' },
    { name: 'TypeScript', icon: '/typescript-logo.png' },
    { name: 'HTML', icon: '/html-logo.png' },
    { name: 'CSS', icon: '/css-logo.png' },
    { name: 'JavaScript', icon: '/javascript-logo.png' },
    { name: 'Arduino', icon: '/arduino-logo.png' },
];

const tools = [
    { name: 'Jira', icon: '/jira-logo.png' },
    { name: 'Linux', icon: '/linux-logo.png' },
    { name: 'Figma', icon: '/figma-logo.png' },
    { name: 'Xcode', icon: '/xcode-logo.png' },
    { name: 'GitHub', icon: '/github-logo.png' },
    { name: 'VS Code', icon: '/vscode-logo.png' },
    { name: 'Notion', icon: '/notion-logo.png' },
    { name: 'SQL', icon: '/sql-logo.png' },
];

// Function to create stack items
function createStackItems(items, containerId) {
    const container = document.getElementById(containerId);
    items.forEach(item => {
        const div = document.createElement('div');
        div.className = 'stack-item';
        div.innerHTML = `
            <img src="${item.icon}" alt="${item.name}" />
            <span>${item.name}</span>
        `;
        container.appendChild(div);
    });
}

// Initialize stack items
document.addEventListener('DOMContentLoaded', () => {
    createStackItems(languages, 'languages');
    createStackItems(tools, 'tools');

    // Contact form handling
    const contactForm = document.getElementById('contactForm');
    contactForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = {
            fullName: this.fullName.value,
            email: this.email.value,
            userType: this.userType.value,
            message: this.message.value
        };
        console.log('Form submitted:', formData);
        // Aquí iría la lógica para enviar el formulario
        alert('Formulario enviado con éxito!');
        this.reset();
    });
});
























// document.getElementById('miFormulario').addEventListener('submit', function(event) {
//     event.preventDefault();

//     // Recoger los datos del formulario
//     const formData = {
//         nombre: document.getElementById('nombre').value,
//         correo: document.getElementById('correo').value,
//         tipo: document.getElementById('tipo').value,
//         mensaje: document.getElementById('mensaje').value
//     };

//     // Enviar los datos a la API
//     fetch('https://magicloops.dev/api/loop/run/14eb826b-7d85-4fee-b321-6048b3da8f33', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(formData)
//     })
//     .then(response => response.json())
//     .then(data => {
//         console.log('Éxito:', data);
//         alert('Datos enviados correctamente.');
//     })
//     .catch((error) => {
//         console.error('Error:', error);
//         alert('Ocurrió un error al enviar los datos.');
//     });
// });
