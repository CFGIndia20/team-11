# St. JUDE INDIA CHILDCARE CENTRES APP

This project was built for the non-profit organization - St Jude India ChildCare Centres - as a part of the Code For Good Hackathon 2020 organized by JPMorgan and Chase. SJICC provides clean, safe and cost free accomodation to children and their accompanying relatives coming from small villages who are undergoing treatment for chronic diseases in metro cities. of India. Our solution aims at solving the critical challenges faced by the organization such as language barriers with the beneficiaries and providing quick automated responses to the donors' queries.

## Technologies Used

-   Android Java
-   Node.js
-   MongoDB and Mongoose

## Facts and Assumptions

### FACTS:

-   Donors have smartphones and are educated.
-   Beneficiaries have feature phones.
-   Hassle free transport to and from the hospitals.

### ASSUMPTIONS:

-   Patients come before Donors as actors in the flow.
-   Everyone has internet access.
-   Center management staff is manipulative
-   Families originate from rural areas
-   Generate reports first day of month, if any failures send an email to donors

## Specifications

Honest feedback from the patient's family is very crucial to the NGO as best quality of service and help to those in need is their mission. One major challenge that the organization currently faces is manipulation of feedback before the NGO receives it. This can be solved by eliminating the middle-men in the process and ensuring an end-to-end communication; albeit not manual, between the organization and patient's family directly. The beneficiary would receive an easy and elegant user interface with **minimal number of questions asked through IVR in preferred language, and all they have to do is mark/press the corresponding emoticon**. This response would be collected by our platform and accessible only to the NGOs. To ensure that all families fill it, we would not ask too many questions at once.

We decided to have 3 logins for 3 different actors in the process - NGO, Donor, Centre Management System.
NGO login leads to a dashboard where they can get deep insights based on the feedback received from the patient's families after their stay is over. This can help them improve their quality of service.
Donors can login and get access to regular reports on the platform instead of emails. They can also direct their queries to a chatbot that fetches dynamic data from the database and provides quick automated responses for better user experience for the donors.
Centre Management Staff can login and get information about their center like ratings, no. of units occupied, and handling the trigger for the report updates for the donors.

## Our Solution

We have built an MVP that tries to address the issues for the organization.

**Step 1:** The user logs-in/ signs-up according to their role

**Step 2a:** NGO dashboard

**Step 2b:** Donor Dashboard

**Step 2c:** Centre Management Staff Dashboard

**Step 3:** Patient's Family Feedback Form

## Future Scope

The patient's family can be given brownie points for filling the feedback form so they don't avoid it.

## Video Link

https://www.youtube.com/watch?v=IvOdYUwzKZ0&feature=youtu.be
