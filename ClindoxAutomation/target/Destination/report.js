$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UpdateAnswers.feature");
formatter.feature({
  "line": 2,
  "name": "Update Answers",
  "description": "",
  "id": "update-answers",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@demo"
    }
  ]
});
formatter.before({
  "duration": 1175449709,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "login to application with default user",
  "keyword": "Given "
});
formatter.match({
  "location": "SelectRoleSteps.login_to_application_with_default_user()"
});
formatter.result({
  "duration": 21525353548,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Enter data from Input Sheet.",
  "description": "",
  "id": "update-answers;enter-data-from-input-sheet.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@input"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "user is on Dashboard Page",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "set user role as \"Investigator\"",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "User Enters data from Input Sheet",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "data should be saved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "SelectRoleSteps.user_is_on_Dashboard_Page()"
});
formatter.result({
  "duration": 2887033,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Investigator",
      "offset": 18
    }
  ],
  "location": "SelectRoleSteps.set_user_role_as(String)"
});
formatter.result({
  "duration": 2109455071,
  "status": "passed"
});
formatter.match({
  "location": "UpdateAnswersSteps.user_Enters_data_from_Input_Sheet()"
});
formatter.result({
  "duration": 68684588071,
  "status": "passed"
});
formatter.match({
  "location": "UpdateAnswersSteps.data_should_be_saved_successfully()"
});
formatter.result({
  "duration": 26881,
  "status": "passed"
});
formatter.after({
  "duration": 2024830832,
  "status": "passed"
});
});