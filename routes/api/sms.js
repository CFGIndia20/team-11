const accountSid = process.env.ACCOUNTSID;
const authToken = process.env.AUTHTOKEN;
const client = require('twilio')(accountSid, authToken);

client.messages
  .create({
     body: 'https://forms.gle/5L2FApSLm796GBmHA',
     from: process.env.FROMSMS,
     to: process.env.TOSMS
   })
  .then(message => console.log(message.sid));