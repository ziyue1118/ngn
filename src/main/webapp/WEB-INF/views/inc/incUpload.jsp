<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p>Welcome to Upload page</p>
<button class="btn btn-primary" data-toggle="modal" data-target="#UploadModal">
  Upload
</button>

<!-- Modal -->
<div class="modal fade" id="UploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Upload Your Photos</h4>
      </div>
      <div class="modal-body">
      		<dl>
      			<dt>Photos:</dt><dd><button class="btn btn-default" onclick="pick()">choose file</button>
      			<div id="uploadFilename"></div></dd>
            <dt>Location: </dt>
            <dd>
              <input id="pac-input" class="controls" type="text"
                placeholder="Enter a location">
              <div id="map-canvas"></div>

              
            </dd>
        		<dt>Descriptions:</dt><dd><textarea class="description-box" rows="2"></textarea></dd>
      		</dl>
      </div>
      <form:form method="POST" action="/upload/photo" commandName="myform">
      
			  <form:label path="locationName">locationName</form:label>
              <form:input path="locationName"/>
              <form:label path="latitude">latitude</form:label>
              <form:input path="latitude"/>
              <form:label path="longitude">longitude</form:label>
              <form:input path="longitude"/>
              <form:label path="description">description</form:label>
              <form:input path="description"/>
              <form:label path="imgurl">imgurl</form:label>
              <form:input path="imgurl"/>
              <form:label path="userId">userId</form:label>
              <form:input path="userId"/>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" value="Submit" />
      </div>
     </form:form>
    </div>
  </div>
</div>

