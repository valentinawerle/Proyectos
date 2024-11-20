const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const axios = require('axios');
const app = express();
const port = 3000;

app.use(bodyParser.urlencoded({ extended: true }));

// Servir archivos estáticos
app.use(express.static(path.join(__dirname, 'www')));

// Ruta principal
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'www', 'index.html'));
});

app.post('/submit-form', async (req, res) => {
    const formData = req.body;
    console.log({backend: formData});

    try {
        // envia los datos al API de salesforce
        const response = await axios.post('https://webto.salesforce.com/servlet/servlet.WebToCase?encoding=UTF-8&orgId=00DHs000000QSJA', {
            ...formData,
            orgId: '00DHs000000QSJA',
            retURL: 'https://www.lepton.com.ar/web/soporte/soporte-tecnico'
        });
        console.log({saleforce: response});
        // const response2 = await axios.post('http://localhost:40000/submit-form', {
        //     ...formData,
        //     orgId: '00DHs000000QSJA',
        //     retURL: 'https://www.lepton.com.ar/web/soporte/soporte-tecnico'
        // });

        // redirecciona o envia una respuesta al cliente
        res.redirect('https://www.lepton.com.ar/web/soporte/soporte-tecnico');
    } catch (error) {
        console.error('Error al enviar el formulario:', error);
        res.status(500).send('Hubo un problema al enviar el formulario.');
    }
});

app.listen(port, () => {
    console.log(`Servidor escuchando en http://localhost:${port}`);
});
