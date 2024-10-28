function createStackItems(items, containerId) {
    const container = document.getElementById(containerId);

    items.forEach(item => {
        const div = document.createElement('div');

        div.className = 'stack-skill';
        div.innerHTML = (
            `
                <div class="icon icon-stack">
                    <img src="${item.icon}" alt="${item.name}" />
                </div>
                <span>${item.name}</span>
            `
        );
        container.appendChild(div);
    });
}

export { createStackItems };
