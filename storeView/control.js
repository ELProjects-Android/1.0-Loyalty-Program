            // function to render offers
            function offer(data){
                var off = "<div class='panel panel-default'>"+
                          "<div class='panel-body'><strong style='margin: 20px;margin-top: 30px;font-size: 15px;''>"+data.description+"</strong>"+
                          "<button type='button' class='btn btn-danger' style='float:right;'>Reject</button>"+
                          "<button type='button' class='btn btn-success' style='float:right; margin-right:20px;' onclick='offerid.push("+data.orderId+");'>Accept</button>"+
                          "</div>"; 
                $('#offer').append(off);
            }

            // function to call during checkout
            function subb(data){
                var tax = $('#tax').val();
                var of = offerid.toString();
                console.log(offerid.toString());
                console.log(tax);
                $.get( "test.html",{storeId:store_id, userId:customer_id, offerIds:of,txnAmount:tax}, function( data ) {
                    if(data == "true"){
                        console.log("Completed");
                    }
                    
                });

            }

            //to render user details form the json data
            function details_render(id){
                
                $.get( "test2.php", { 
                        
                }, function( result ){
                  json_data = JSON.parse(result);
                    for(i=0;i<json_data.length;i++){
                     offer(json_data[i]);
                    }
                });

                details({
                image: json_data[id].image,
                customer_id: json_data[id].userId,
                most_bought_item: "null",
                last_brought_item: json_data[id].lastBuy,
                buy_value: json_data[id].totalBuy,
                checkin_date: json_data[id].lastCheckIn,
                shopping_date: json_data[id].lastShopped,
                customer_type: json_data[id].membershipType,
                customer_name: json_data[id].name,
                customer_point: json_data[id].points
                });

            }

            // login funtion
            /* function login(data){
                var login_modal ="<div class='modal fade' id='myModal' role='dialog>"+
                "<div class='modal-dialog' style='padding:100px;width:800px;overflow: hidden;margin-left:20%;'>"+
                "<div class='panel panel-default' style='text-align:left;' ng-controller='leftCtrl'>"+
                  "<div class='panel-body'>"+
                    "<button type='button' class='close' data-dismiss='modal'>&times;</button>"+
                    "<div class='container' style='width:300px;'>"
                        +"<h2 class='form-signin-heading'>Please sign in</h2>"
                        +"<label for='inputEmail' class='sr-only'>Email address</label>"
                        +"<input id='email' type='email' id='inputEmail' class='form-control' style='margin-bottom:10px;' placeholder='Email address' required autofocus>"
                        +"<label id='pass' for='inputPassword' class='sr-only'>Password</label>"
                        +"<input type='password' id='inputPassword' class='form-control' placeholder='Password' required>"
                        +"<div class='checkbox'>"+
                          "<label>"+
                            "<input type='checkbox' value='remember-me'> Remember me"+
                          "</label>"+
                        "</div>"+
                        "<button class='btn btn-lg btn-primary btn-block' type='submit' onclick='check();'>Sign in</button>"+
                    "</div>"+"<br><br>"+
                    "</div>"+
                "</div>"+
                "</div>"+
                "</div>";
                    $( "#customer_details" ).prepend( login_modal );
        $('#myModal').modal('show');
            } 

        */
        

            // function to render user details once the retailer clicks on a user
            function details(data){
                $( "#customer_details" ).empty();
                var image = data.image;
                 customer_id = data.customer_id;
                var most_bought_item = data.most_bought_item;
                var last_brought_item = data.last_brought_item;
                var buy_value = data.buy_value;
                var checkin_date = data.checkin_date;
                var shopping_date = data.shopping_date;
                var customer_type = data.customer_type;
                var customer_name = data.customer_name;
                var customer_point = data.customer_point;
                var div = "<div class='modal fade' id='myModal' role='dialog>"+
                "<div class='modal-dialog' style='padding:100px;width:800px;overflow: hidden;margin-left:20%;'>"+
                "<div class='panel panel-default' style='text-align:left;' ng-controller='leftCtrl'>"+
                  "<div class='panel-body'>"+
                    "<button type='button' class='close' data-dismiss='modal'>&times;</button>"+
                      "<div class='row'>"+
                        "<div class='col-lg-4 text-center' style=''>"+
                            "<img src='"+image+"' style='width:100px;margin-top:20px;'>"+
                        "</div>"+
                        "<div class='col-lg-8 text-center' style='text-align:left;'>"+
                            "<div style=''>"+
                                "<p><b>Name: </b> "+customer_name+"</p>"+
                                "<p><b>Points: </b> "+customer_point+"</p>"+
                                "<p><b>Total Buy Value: </b>"+buy_value+"</p>"+
                                "<p><b>Last Checkin Date: </b>"+checkin_date+"</p>"+
                                "<p><b>Last Shopping Date:</b> "+shopping_date+"</p>"+
                            "</div>"+
                            "<p><b>Customer Type - </b>"+customer_type+"</p>"+
                        "</div>"+
                        "</div>"+
                        "<div style='overflow: auto;height:100px;' id='offer'>"+
                            
                        "</div>"+
                        "<div class='form-group'>"+
                          "<input type='text' class='form-control' id='tax' placeholder='Total Amount' style='float:left;width:500px; margin-top:20px;margin-left:20px;'>"+
                          "<button type='button' class='btn btn-info' style='float:right; margin-top:20px;margin-right:20px;' onclick='subb();'>Checkout</button>"+
                        "</div>"+
                  "</div>"+
                "</div>"+
            "</div>"+
        "</div>";

        $( "#customer_details" ).prepend( div );
        $('#myModal').modal('show');
            }
            // this function adds users to the default list
            function add_customer(data, id){
                var i =id;
                var image = data.image;
                var customer_id =  data.userId;
                var customer_name = data.name;
                var customer_point = data.points;
                var customer_type = data.membershipType;
                var div = "<div class='panel panel-success' style='text-align:left;' onclick= details_render("+ i +")>"+
                            "<div class='panel-body'>"+
                                "<div class='row'>"+
                                    "<div class='col-lg-4 text-center' style=''>"+
                                        "<img src='"+image+"' style='width:50px;'>"+
                                    "</div>"+
                                    "<div class='col-lg-8 text-center' style='text-align:left;margin-top:10px;font-size:15px;'>"+
                                        "<p><b >ID</b> "+customer_id+" <b style='margin-left:20px;'>Name </b>"+customer_name+"    <b style='margin-left:20px;'>Points</b> "+customer_point+"         <b style='margin-left:20px;'>Type</b> "+customer_type+"</p>"+
                                    "</div>"+
                                "</div>"+
                            "</div>"+
                        "</div>";
                $( "#customer_pannel" ).prepend( div );
            }
            // Cookie function, not to be modified 
            $(document).ready(function() {
                function getCookie(cname) {
                    var name = cname + "=";
                    var ca = document.cookie.split(';');
                    for(var i=0; i<ca.length; i++) {
                        var c = ca[i];
                        while (c.charAt(0)==' ') c = c.substring(1);
                        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
                    }
                    return "";
                }
                // Get store ID out of the cookie
                store_id = getCookie(storeId);

                // Array to store offer
                offerid =[];
                
                // function to get user details
                  function check(){
                    $.get( "test.php", { 
                        storeId:store_id
                    }, function( result ){
                      json_data = JSON.parse(result);
                      num_users = json_data.length;
                        for(i=0;i<num_users;i++){
                            add_customer(json_data[i], i);
                        }
                    var sc = "Current Customers "+ num_users;
                    $('#current_customers').html(sc);
                    });
                }

                // function call to check for user details
                check();

                //Set interval of to check for details
                window.setInterval(function(){
                $('#customer_pannel').empty();
                check();
                }, 10000);
              });