function cateChart(id, statusLabels=[], statusInfo=[]){
const data = {
  labels: [
    'Red',
    'Blue',
    'Yellow'
  ],
  datasets: [{
    label: 'My First Dataset',
    data: [300, 50, 100],
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)'
    ],
    hoverOffset: 4
  }]
};
const config = {
  type: 'doughnut',
  data: data,
};
var options = {        
    cutout:40
};
let ctx = document.getElementById(id).getContext("2d")
//new Chart(ctx,config)
myNewChart = new Chart(ctx,config).Doughnut(data, options);
}


















/*function cateChart(id, statusLabels=[], statusInfo=[]){
	const data = {
  labels:cateLabels,
  datasets: [{
    label: 'Thong ke tinh trang don hang',
    data: [300, 50, 100],
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)',
      'rgb(0,255,0)',
      'rgb(255,102,255)',
      'rgb(0,0,0)'
      
    ],
    hoverOffset: 4
  }]
};
const config = {
  type: 'doughnut',
  data: data,
};
let ctx = document.getElementById(id).getContext("2d")
new Chart(ctx,config)
}*/