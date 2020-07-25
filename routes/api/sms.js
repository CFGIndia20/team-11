const accountSid = 'AC3607f9f437373921052f9480b3a54109';
const authToken = '5b9b29e56aa9e438f5345c2ec8f6d554';
const client = require('twilio')(accountSid, authToken);

client.messages
  .create({
     body: 'https://forms.gle/5L2FApSLm796GBmHA',
     from: '+19412410249',
     to: '+919503697989'
   })
  .then(message => console.log(message.sid));