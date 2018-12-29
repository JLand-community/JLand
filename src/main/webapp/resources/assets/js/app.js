/*Scroll To Top Button*/
var goUpButton = document.getElementById('goUpButton');
window.onscroll = function () {
  'use strict';
  if (window.pageYOffset >= 100) {
    goUpButton.style.display = 'block';
  } else {
    goUpButton.style.display = 'none';
  }
};
goUpButton.onclick = function () {
  'use strict';
  window.scrollTo(0, 0);
};



document.getElementById("dropdownForPresentationName").addEventListener("click", openPresentationPlan);
function openPresentationPlan() {
  fetch('http://localhost:8080/presentations/1/plan')
    .then(function (response) {return response.json()})
    .then(function (response) {console.log(response)})
    .catch(function (reason) {console.log(reason)});
  document.getElementById("presentationPlanForPresentationName").classList.toggle("active");
}

document.getElementById("dropdownForAgenda").addEventListener("click", openAgenda);
function openAgenda() {
  fetch('http://localhost:8080/presentations/conferences/1')
    .then(function (response) {return response.json()})
    .then(function (response) {console.log(response)})
    .catch(function (reason) {console.log(reason)});
  document.getElementById("agendaList").classList.toggle("active");
}








