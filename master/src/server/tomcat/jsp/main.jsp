<!doctype html>
<head>
	<title>Morne Test - Main</title>

	<link rel="stylesheet" href="../lib/jquery/jquery-ui.css">
	<link rel="stylesheet" href="../css/common.css">

	<script src="../lib/jquery/jquery-1.9.1.js"></script>
	<script src="../lib/jquery/jquery-ui.js"></script>

	<style>
		<style type=text/css>
			div.ui-accordion-content {
				font-size : 10pt;
			}
	</style>

	<script>
		$(function() {
			$( "#accordion" ).accordion({
				heightStyle: "fill"
			});
		});
	</script>
</head>
	<body id = "main-body">
		<div id = "div-logo">
			Logo to be placed here
		</div>

		<div id = "div-header">
			Header to be placed here
		</div>

		<div id = "div-left">

			<div id="accordion">
				<h1 style = "font-size : 10pt;">Section 1</h1>
				<div>
					xxx
					<p style = "font-size : 10pt;">
						Some content
					</p>
					<p style = "font-size : 10pt;">
						Some content 2
					</p>
				</div>
				<h1 style = "font-size : 10pt;">Section 2</h1>
				<div>
					<p>

					</p>
				</div>
				<h1 style = "font-size : 10pt;">Section 3</h1>
				<div>
					<p>
					</p>
				</div>
				<h1 style = "font-size : 10pt;">Section 4</h1>
				<div>
					<p>

					</p>
				</div>
			</div>

		</div>

		<div id = "div-main">
			Main menu to be placed here
		</div>
	</body>
</html>
