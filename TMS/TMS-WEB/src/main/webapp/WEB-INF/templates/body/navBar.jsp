<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<div class="navbar main">
		<a href="index.html?lang=en" class="appbrand"><span>TMS<span>Talent Management System</span></span></a>
			
			<button type="button" class="btn btn-navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<ul class="topnav pull-right">				
				<li>
					<span>
						<a class="btn btn-default btn-small pull-right" style="padding: 2px 10px; background: #fff;" href="login.html?lang=en">Sign Out</a>
					</span>
				</li>
			</ul>
		</div>
		
		
<%-- 
		<div class="navbar main">
			<a href="index.html?lang=en" class="appbrand"><span>Admin+ <span>lovely headline here</span></span></a>
			
			<button type="button" class="btn btn-navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
						
			<ul class="topnav pull-right">
				<li class="visible-desktop">
					<ul class="notif">
						<li><a href="" class="glyphicons envelope" data-toggle="tooltip" data-placement="bottom" data-original-title="5 new messages"><i></i> 5</a></li>
						<li><a href="" class="glyphicons shopping_cart" data-toggle="tooltip" data-placement="bottom" data-original-title="1 new orders"><i></i> 1</a></li>
						<li><a href="" class="glyphicons log_book" data-toggle="tooltip" data-placement="bottom" data-original-title="3 new activities"><i></i> 3</a></li>
					</ul>
				</li>
				<li class="dropdown visible-desktop">
					<a href="" data-toggle="dropdown" class="glyphicons cogwheel"><i></i>Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="">Some option</a></li>
						<li><a href="">Some other option</a></li>
						<li><a href="">Other option</a></li>
					</ul>
				</li>
								<li class="hidden-phone">
					<a href="#themer" data-toggle="collapse" class="glyphicons eyedropper"><i></i><span>Themer</span></a>
					<div id="themer" class="collapse">
						<div class="wrapper">
							<span class="close2">× close</span>
							<h4>Themer <span>color options</span></h4>
							<ul>
								<li>Theme: <select id="themer-theme" class="pull-right"><option value="0">Default</option><option value="1">Brown</option><option value="2">Purple-Gray</option><option value="3">Purple-Wine</option><option value="4">Blue-Gray</option><option value="5">Green Army</option><option value="6">Black &amp; White</option></select><div class="clearfix"></div></li>
								<li>Primary Color: <span class="minicolors minicolors-position-left"><input type="text" data-type="minicolors" data-default="#DA4C4C" data-slider="hue" data-textfield="false" data-position="left" id="themer-primary-cp" size="7" maxlength="7" class="minicolors-hidden"><span class="minicolors-swatch"><span style="background-color: rgb(55, 166, 205);"></span></span><span class="minicolors-panel minicolors-slider-hue" style="display: none;"><span class="minicolors-slider"><span class="minicolors-picker" style="top: 8.22px;"></span></span><span class="minicolors-opacity-slider"><span class="minicolors-picker"></span></span><span class="minicolors-grid" style="background-color: rgb(0, 187, 255);"><span class="minicolors-grid-inner"></span><span class="minicolors-picker" style="top: 3px; left: 0px;"><span></span></span></span></span></span><div class="clearfix"></div></li>
								<li>
									<span class="link" id="themer-custom-reset">reset theme</span>
									<span class="pull-right"><label>advanced <input type="checkbox" value="1" id="themer-advanced-toggle"></label></span>
								</li>
							</ul>
							<div id="themer-getcode" class="hide">
								<hr class="separator">
								<button class="btn btn-primary btn-small pull-right btn-icon glyphicons download" id="themer-getcode-less"><i></i>Get LESS</button>
								<button class="btn btn-inverse btn-small pull-right btn-icon glyphicons download" id="themer-getcode-css"><i></i>Get CSS</button>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</li>
								<li class="hidden-phone">
					<a href="#" data-toggle="dropdown"><img src="theme/images/lang/en.png" alt="en"></a>
			    	<ul class="dropdown-menu pull-right">
			      		<li class="active"><a href="?page=index&amp;lang=en" title="English"><img src="theme/images/lang/en.png" alt="English"> English</a></li>
			      		<li><a href="?page=index&amp;lang=ro" title="Romanian"><img src="theme/images/lang/ro.png" alt="Romanian"> Romanian</a></li>
			      		<li><a href="?page=index&amp;lang=it" title="Italian"><img src="theme/images/lang/it.png" alt="Italian"> Italian</a></li>
			      		<li><a href="?page=index&amp;lang=fr" title="French"><img src="theme/images/lang/fr.png" alt="French"> French</a></li>
			      		<li><a href="?page=index&amp;lang=pl" title="Polish"><img src="theme/images/lang/pl.png" alt="Polish"> Polish</a></li>
			    	</ul>
				</li>
				<li class="account">
										<a data-toggle="dropdown" href="form_demo.html?lang=en" class="glyphicons logout lock"><span class="hidden-phone text">mosaicpro</span><i></i></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="form_demo.html?lang=en" class="glyphicons cogwheel">Settings<i></i></a></li>
						<li><a href="form_demo.html?lang=en" class="glyphicons camera">My Photos<i></i></a></li>
						<li class="highlight profile">
							<span>
								<span class="heading">Profile <a href="form_demo.html?lang=en" class="pull-right">edit</a></span>
								<span class="img"></span>
								<span class="details">
									<a href="form_demo.html?lang=en">Mosaic Pro</a>
									contact@mosaicpro.biz
								</span>
								<span class="clearfix"></span>
							</span>
						</li>
						<li>
							<span>
								<a class="btn btn-default btn-small pull-right" style="padding: 2px 10px; background: #fff;" href="login.html?lang=en">Sign Out</a>
							</span>
						</li>
					</ul>
									</li>
			</ul>
		</div>
	--%>
