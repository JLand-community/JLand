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
/*Agenda dropdown*/
document.getElementById("dropdownForAgenda").addEventListener("click", openAgenda);

function openAgenda() {
  document.getElementById("agendaList").classList.toggle("active");
}

/*Presentation Plan dropdown*/
function openPresentationPlan(eventId) {
    document.getElementById(eventId).classList.toggle("active");
}



