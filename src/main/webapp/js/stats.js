function cateChart(id, statusLabels=[], statusInfo=[]){
const data = {
  labels: statusLabels,
  datasets: [{
    label: 'Thong ke tinh trang don hang',
    //data: [300, 50, 100,200,60,90],
    data: statusInfo,
    backgroundColor: [
      'rgb(233,177,10)',
      'rgb(255,0,255)',
      'rgb(23,149,206)',
      'rgb(0,255,0)',
      'rgb(255,0,0)',
      'rgb(0,0,0)'
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
new Chart(ctx,config)
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