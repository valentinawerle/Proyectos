import { createStackItems } from "./src/functionality/create-stack-items/index.js";
import { submitFormData } from "./src/functionality/send-form/index.js";
import { typewriterEffect } from "./src/functionality/typewriter-effect/index.js";

import { tools } from "./src/constants/tools.js";
import { languages } from "./src/constants/languages.js";

document.addEventListener('DOMContentLoaded', () => {
    typewriterEffect();
    createStackItems(languages, 'languages');
    createStackItems(tools, 'tools');
    submitFormData('contactForm');
});
