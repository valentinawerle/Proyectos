

// Stack data
const languages = [
    { name: 'Python', icon: 'https://upload.wikimedia.org/wikipedia/commons/c/c3/Python-logo-notext.svg' },
    { name: 'Java', icon: 'https://img.icons8.com/?size=100&id=13679&format=png&color=000000' },
    { name: 'C', icon: 'https://img.icons8.com/?size=512&id=40670&format=png' },
    { name: 'TypeScript', icon: 'https://img.icons8.com/?size=100&id=wpZmKzk11AzJ&format=png&color=000000' },
    { name: 'JavaScript', icon: 'https://img.icons8.com/?size=100&id=108784&format=png&color=000000' },
    { name: 'HTML', icon: 'https://img.icons8.com/?size=100&id=20909&format=png&color=000000' },
    { name: 'CSS', icon: 'https://img.icons8.com/?size=100&id=21278&format=png&color=000000' },
    { name: 'Arduino', icon: 'https://img.icons8.com/?size=100&id=13444&format=png&color=000000' },
];

const tools = [
    { name: 'Jira', icon: 'https://cdn-icons-png.flaticon.com/512/5968/5968875.png' },
    { name: 'Linux', icon: 'https://img.icons8.com/?size=100&id=17842&format=png&color=000000' },
    { name: 'Figma', icon: 'https://img.icons8.com/?size=100&id=W0YEwBDDfTeu&format=png&color=000000' },
    { name: 'Postman', icon: 'https://cdn.iconscout.com/icon/free/png-256/free-cartero-3628992-3030217.png?f=webp' },
    { name: 'GitHub', icon: 'https://img.icons8.com/m_sharp/200/FFFFFF/github.png' },
    { name: 'VS Code', icon: 'https://img.icons8.com/?size=100&id=9OGIyU8hrxW5&format=png&color=000000' },
    { name: 'Notion', icon: 'https://upload.wikimedia.org/wikipedia/commons/4/45/Notion_app_logo.png' },
    { name: 'SQL', icon: 'https://img.icons8.com/?size=100&id=qGUfLiYi1bRN&format=png&color=000000' },
];

// Function to create stack items
function createStackItems(items, containerId) {
    const container = document.getElementById(containerId);
    items.forEach(item => {
        const div = document.createElement('div');
        div.className = 'stack-item';
        div.innerHTML = `
            <img src="${item.icon}" alt="${item.name}" class="stack-image"/>
            <span>${item.name}</span>
        `;
        container.appendChild(div);
    });
}

// Initialize stack items
document.addEventListener('DOMContentLoaded', () => {
    createStackItems(languages, 'languages');
    createStackItems(tools, 'tools');
})

//Envio de formulario
document.getElementById('contactForm').addEventListener('submit', async function (event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma tradicional

    const formData = new FormData(this);
    const data = Object.fromEntries(formData.entries()); // Convierte FormData a un objeto JSON

    try {
        const response = await fetch('https://formspree.io/f/xgveodaa', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (response.ok) {
            alert('Message sent successfully!');
            this.reset(); // Reinicia el formulario
        } else {
            alert('Failed to send message. Please try again.');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('An error occurred. Please try again later.');
    }
});