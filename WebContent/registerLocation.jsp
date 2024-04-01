<%@ page import="com.jayesh.condb.JayShreeRam" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap(1).css">
<link rel="stylesheet" href="css/style(1.css)">
<style>
	.row {
            background-image: url(images/registerback.jpg);
            margin-right: 129px;
            margin-left: 108px;
            margin-bottom: 30px;
        }
        .buy_btn{
        	background-color: #000000;
  color: white;
  padding: 14px 25px;
  margin-left:220px;
  width:30px;
  height: 43px;
    width: 82px;
  font-size:15px;
  letter-spacing: 3px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
        }
</style>
</head>
<body>
<%
  String lat=request.getParameter("lat");
  String lng=request.getParameter("lng");
  
  
  System.out.println("lat "+lat);
  System.out.println("lng "+lng);
  
  %>
<%-- <form action="getlocation" method="post" onsubmit="return validation()">
				
					 
				    <center>
					<label>Name</label>
						<input type="text" placeholder="name" name="name" required />
					</div> 
					
				<br>
						<label>Address</label>
						<input type="text" placeholder="Address" name="address" required/>
					</div> 
					
				<br>
				<div>
				
				</div>	
					
						<label>Taluka</label>
						<input type="text" placeholder="taluka" name="taluka" required />
					</div> 
					
				<br>
				
					<label>Latitude</label>
						
						<input class="form-control" type="text" value="<%=lat %>" placeholder="lat" name="lat" required/> 
					</div> 
				<br>
					 <label>Longitude</label>
						
						<input class="form-control" type="text" value="<%=lng %>"placeholder="lng" name="lng" required/>
                                            
					</div>
					</div>
					<br/>
				

				<input type="submit" value="Submit"></div>
				</center>
				
				</form> --%>
				














 <div class="backimg">-
    <div class="row">
        <h3 class="title1">Registration Form :</h3>
        <div class="form-three widget-shadow">
            <form class="form-horizontal" action="location" method="post" onsubmit="return validation()" >
                <div class="form-group">
                    <label for="focusedinput" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control1" id="focusedinput" placeholder="Enter Name" name="name">
                    </div>
                    
                </div>
                
                 <div class="form-group">
                    <label for="focusedinput" class="col-sm-2 control-label">Address</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control1" id="focusedinput" placeholder="Address" name="address">
                    </div>
                    
                </div>
                
                 <div class="form-group">
                    <label for="focusedinput" class="col-sm-2 control-label">Taluka</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control1" id="focusedinput" placeholder="Taluka" name="taluka">
                    </div>
                    
                </div>
                
                 <div class="form-group">
                    <label for="focusedinput" class="col-sm-2 control-label">Quantity</label>
                    <div class="col-sm-8">
                        <input type="number" class="form-control1" id="focusedinput" placeholder="Enter quantity" name="sales" min=1>
                    </div>
                    
                </div>
                
                 <div class="form-group">
                    <label for="focusedinput" class="col-sm-2 control-label">Latitude</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control1" value="<%=lat %>" id="focusedinput" placeholder="lat" name="lat">
                    </div>
                    
                </div>
                
                 <div class="form-group">
                    <label for="focusedinput" class="col-sm-2 control-label">Longitude</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control1" value="<%=lng %> id="focusedinput" placeholder="lng" name="lng">
                    </div>
                    
                </div>
                
               
                
            
                

                <button type="submit" class="buy_btn">Buy</button>

		   </form>
        </div>
    </div>
</div>




</body>
</html>