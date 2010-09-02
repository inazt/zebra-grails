<html>
      <head>
          <title>An Example Page</title>
      </head>
      <body onload="">
        <div class="menu"><!--my common menu goes here--></div>
                 <div class="body">
					<g:set var="now" value="${result}" />	
					<p>Filename : ${filename}</p>
					<p>Format : ${format}, Type : ${type}</p>
					<p>parsedResult: ${parsedResult}</p>
					<p>Result :  ${result}</p>
					<g:link url="[action:'index',controller:'upload']">Upload Another</g:link>
                 </div>
      </body>
</html>
