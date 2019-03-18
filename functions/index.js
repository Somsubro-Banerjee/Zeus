const functions = require('firebase-functions');
 https://firebase.google.com/docs/functions/write-firebase-functions

 exports.helloWorld = functions.https.onRequest((request, response) => {
  response.send("Hello from Firebase!");
 });
