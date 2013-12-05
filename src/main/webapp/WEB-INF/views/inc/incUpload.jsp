<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="user-photo-wrapper">
  <div class="upload-wrapper">
    <div class="upload-container">
      <dl>
        <dt>Photos:</dt><dd><button class="btn btn-warning" onclick="pick(${userid})">choose file</button>
        <div id="uploadFilename"></div></dd>
        <dt>Location: </dt>
        <dd>
          <input id="pac-input" class="controls" type="text"
          placeholder="Enter a location">
          <div id="map-canvas"></div>
        </dd>
        <form:form method="POST" action="/upload" commandName="myform">
        <dt>Descriptions:</dt>
        <dd><form:textarea path="description" cssClass="description-box"/>
          <form:hidden path="locationName"/>
          <form:hidden path="latitude"/>
          <form:hidden path="longitude"/>
          <form:hidden path="imgurl"/>
          <form:hidden path="userId" value="${userid}"/>
          <div id="upload-button"> <input type="submit" class="btn btn-primary"value="Upload"></div>
        </dd> 
      </form:form>
    </dl>
  </div>
</div>
</div>


<!-- <button class="btn btn-primary" data-toggle="modal" data-target="#UploadModal">
  Upload
</button> -->

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
      			<dt>Photos:</dt><dd><button class="btn btn-default" onclick="pick(${userid})">choose file</button>
      			<div id="uploadFilename"></div></dd>
            <dt>Location: </dt>
            <dd>
              <input id="pac-input" class="controls" type="text"
                placeholder="Enter a location">
              <div id="map-canvas"></div>
            </dd>
            <form:form method="POST" action="/upload" commandName="myform">
            <dt>Descriptions:</dt><dd><form:textarea path="description" cssClass="description-box"/></dd> 
          </dl>
      </div>
              <form:hidden path="locationName"/>
              <form:hidden path="latitude"/>
              <form:hidden path="longitude"/>
              <form:hidden path="imgurl"/>
              <form:hidden path="userId" value="${userid}"/>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary"value="Submit">
      </div>
     </form:form>
    </div>
  </div>
</div>

