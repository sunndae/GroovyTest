
//script para el manejo de los botones

let btn = document.querySelector('#btn');
let sidebar = document.querySelector('.sidebar');

btn.onclick = function() {

    sidebar.classList.toggle('active');
};