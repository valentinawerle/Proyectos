import { LANGUAGES, TOOLS } from './const.mjs'

/**
 * @param {string} id
 */
const $id = id => document.getElementById(id)

/**
 * Acá podes usar ***[resend](https://resend.com)*** para que te llegue un mensaje de correo usando los datos que ingresa el usuario por el formulario
 * Otras alternativas a resend son
 * 1. ***[FormSubmit](https://formsubmit.co)***
 * 2. ***[Nodemailer](https://nodemailer.com)***
 * 3. ***[EmailJS](https://emailjs.com)***
 * 4. ***[Formspree](https://formspree.io)***
 *
 * @typedef {{ [key: string]: FormDataEntryValue | null}} Data
 * @param {Data} data
 * @return {Error}
 */
function sendEmail(data) {
  console.log(data)
  // const { email, fullName, message, userType } = data
  throw new Error('No implemented function')
}

/**
 * Function to create stack items
 * @param {Array<import('./const.mjs').Tools> | Array<import('./const.mjs').Languages>} items
 * @param {string | (HTMLElement | null)} containerId
 */
function createStackItems(items, containerId) {
  if (containerId == null) return console.error('container isn\'t defined')
  if (containerId instanceof HTMLElement) {
    items.forEach(({ name, icon }) => {
      /** @typedef {HTMLElement} */
      const div = document.createElement('div')
      div.className = 'stack-item'
      div.innerHTML = `
          <img src="${icon}" alt="${name}" />
          <span>${name}</span>
      `
      containerId?.appendChild(div)
    })
  } else {
    /** @type {HTMLElement | null} */
    const container = document.getElementById(containerId)
    items.forEach(({ name, icon }) => {
      /** @typedef {HTMLElement} */
      const div = document.createElement('div')
      div.className = 'stack-item'
      div.innerHTML = `
          <img src="${icon}" alt="${name}" />
          <span>${name}</span>
      `
      container?.appendChild(div)
    })
  }
}

// Initialize stack items
document.addEventListener('DOMContentLoaded', () => {
  createStackItems(LANGUAGES, 'languages');
  createStackItems(TOOLS, 'tools');

  // Contact form handling
  /** @type {HTMLElement | null} */
  const contactForm = $id('contactForm')

  /** @param {SubmitEvent} evt */
  function handleSubmit(evt) {
    evt.preventDefault()
    // Crear una instancia de FormData con el formulario
    const formData = new FormData(this)
    /** @type {{ [key: string]: FormDataEntryValue | null}}  */
    const data = {
      fullName: formData.get('fullName'),
      email: formData.get('email'),
      userType: formData.get('userType'),
      message: formData.get('message')
    }
    sendEmail(data)
    this.reset()
  }
  contactForm?.addEventListener('submit', handleSubmit)
})

/**
 * async function handleEvent(event) {
 *     event.preventDefault();
 *
 *     // Recoger los datos del formulario
 *     const formData = {
 *         nombre: $id('nombre').value,
 *         correo: $id('correo').value,
 *         tipo: $id('tipo').value,
 *         mensaje: $id('mensaje').value
 *     };
 *
 *     const URL_API = 'https://magicloops.dev/api/loop/run/14eb826b-7d85-4fee-b321-6048b3da8f33'
 *
 *     // Enviar los datos a la API
 *     try {
 *         const response = await fetch(URL_API, {
 *             method: 'POST',
 *             headers: {
 *                 'Content-Type': 'application/json'
 *             },
 *             body: JSON.stringify(formData)
 *         })
 *         const res = await res.json()
 *
 *         if (!res.ok) return console.error('')
 *
 *         console.log('Éxito:', data);
 *         alert('Datos enviados correctamente.');
 *     } catch (e) {
 *         if (e instanceof Error) console.error('Ocurrió un error al enviar los datos: ', e.message)
 *         else console.log('Ocurrió un error al enviar los datos: ', e)
 *     }
 * }
 *
 * $id('miFormulario')
 *     .addEventListener('submit', handleEvent);
 */
