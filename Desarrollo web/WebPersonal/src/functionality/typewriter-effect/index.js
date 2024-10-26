const typewriter = document.getElementById("typewriter-text");

const text = "Hi! I'm Valentina Werle";
const speed = 90;

let index = 0;

function typewriterEffect() {
    if (index < text.length) {
        typewriter.textContent += text.charAt(index);
        index++;
        setTimeout(() => requestAnimationFrame(typewriterEffect), speed);
    }
}

export { typewriterEffect };
