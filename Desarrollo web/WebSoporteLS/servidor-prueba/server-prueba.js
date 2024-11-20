const express = require('express');
const bodyParser = require('body-parser');
const axios = require('axios');
const app = express();
const port = 40000;

app.use(bodyParser.urlencoded({ extended: true }));

app.post('/submit-form', async (req, res) => {
    const formData = req.body;
    console.log(formData)

});



app.listen(port, () => {
    console.log(`Servidor escuchando en http://localhost:${port}`);
});
