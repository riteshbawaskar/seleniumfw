$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UpdateAnswers.feature");
formatter.feature({
  "line": 2,
  "name": "Update Answers",
  "description": "\u0027Background:\r\n  \u0027Given login to application with default user",
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
  "duration": 466916759,
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
  "duration": 4518120819,
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
