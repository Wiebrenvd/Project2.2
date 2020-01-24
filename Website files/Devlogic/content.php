<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


<style>
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto;
  padding: 0px;
}
.grid-item {
  padding: 0px;
  font-size: 30px;
  text-align: center;
}
</style>
</head>

<body>
<div class="grid-container">
  <div class="grid-item"> <div class="container">
    <canvas id="myChart"></canvas>
        <script>
            let myChart = document.getElementById('myChart').getContext('2d');
            myChart.canvas.parentNode.style.height = '700px';
            myChart.canvas.parentNode.style.width = '700px';
            // Global Options
            Chart.defaults.global.defaultFontFamily = 'Lato';
            Chart.defaults.global.defaultFontSize = 18;
            Chart.defaults.global.defaultFontColor = '#777';

            let massPopChart = new Chart(myChart, {
            type:'bar', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
            data:{
                labels:['China', 'Khazakstan', 'Georgia', 'Turkmenistan'],
                    datasets:[{
                    label:'Temperature',
                    data:[15,3,8,20],
                    //backgroundColor:'green',
                    backgroundColor:[
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)'],
                    borderWidth:1,
                    borderColor:'#777',
                    hoverBorderWidth:2,
                    hoverBorderColor:'#000'
                }]
            },
            options:{
            title:{
            display:true,
            text:'Gemiddelde temperatuur',
            fontSize:25
            },
            legend:{
                display:true,
                position:'right',
                labels:{
                    fontColor:'#000'
                }
            },
            layout:{
                padding:{
                    left:50,
                    right:0,
                    bottom:0,
                    top:0
                }
            },
            tooltips:{
                enabled:false
            }
        }
    });
  </script>
</div></div>
<div class="grid-item"><div class="container">
    <canvas id="myChar"></canvas>
        <script>
            let myChar = document.getElementById('myChar').getContext('2d');
                myChar.canvas.parentNode.style.height = '700px';
                myChar.canvas.parentNode.style.width = '700px';
                    // Global Options
                Chart.defaults.global.defaultFontFamily = 'Lato';
                Chart.defaults.global.defaultFontSize = 18;
                Chart.defaults.global.defaultFontColor = '#777';

                let massPopChar = new Chart(myChar, {
                type:'line', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
                    data:{
                        labels:['China', 'Khazakstan', 'ect', 'ect', 'ect'],
                            datasets:[
                            {
                                data:[15,3,8,20,33],
                                label:'China',

                                //backgroundColor:'green',
                                backgroundColor:[
                                    'rgba(255, 99, 132, 0.6)'
                                    ],
                                    borderWidth:1,
                                    borderColor:'#777',
                                    hoverBorderWidth:2,
                                    hoverBorderColor:'#000'
                            },
                            {
                                data:[15,9,14,28,35],
                                label:'Khazakstan',

                                //backgroundColor:'green',
                                backgroundColor:[
                                'rgba(54, 162, 235, 0.6)'
                                ],
                                borderWidth:1,
                                borderColor:'#777',
                                hoverBorderWidth:2,
                                hoverBorderColor:'#000'
                            }
                            ]
                                },
                                options:{
                                    title:{
                                    display:true,
                                    text:'Air pressure',
                                    fontSize:25
                                    },
                                    legend:{
                                    display:true,
                                    position:'right',
                                    labels:{
                                    fontColor:'#000'
                                    }
                                },
                                layout:{
                                    padding:{
                                        left:50,
                                        right:0,
                                        bottom:0,
                                        top:0
                                    }
                                },
                                tooltips:{
                                    enabled:true
                                    }
                                }
                            });
        </script>
    </div>
</div>



</body>
</html>

