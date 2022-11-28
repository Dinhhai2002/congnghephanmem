

function cateChart(id,xValues,yValues){
  const data = {
  labels: yValues,
  datasets: [{
    label: 'Doanh thu',
    data: xValues,
    fill: false,
    borderColor: 'rgb(75, 192, 192)',
    tension: 0.1
  }]
};

const config = {
  type: 'line',
  data: data,
};

let ctx = document.getElementById(id)
new Chart(ctx,config)
}


document.getElementById('today').valueAsDate = new Date();
document.getElementById('fromday').value='2022-01-01';




function updateDate(){
	let date = document.getElementById('today').valueAsDate
    document.getElementById('today').value = date.toString();
}