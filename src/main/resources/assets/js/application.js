/*Scroll To Top Button*/
var goUpButton = document.getElementById('goUpButton')
window.onscroll = function () {
  'use strict';
  if (window.pageYOffset >= 100) {
    goUpButton.style.display = 'block';
  } else {
    goUpButton.style.display = 'none';
  }
}
goUpButton.onclick = function () {
  'use strict';
  window.scrollTo(0, 0);
}


document.getElementById("dropdownForPresentationName").addEventListener("click", openPresentationPlan);
function openPresentationPlan() {
  document.getElementById("presentationPlanForPresentationName").classList.toggle("active");
}

document.getElementById("dropdownForAgenda").addEventListener("click", openAgenda);
function openAgenda() {
  document.getElementById("agendaList").classList.toggle("active");
}








