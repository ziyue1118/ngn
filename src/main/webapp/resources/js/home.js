console.log("this is the first javascript");
filepicker.setKey('AgcKB8GxpR92mBoDWt96Cz');
function pick(){
  filepicker.pick({
    mimetypes: ['image/*'],
  },
  function(InkBlob){
    console.log(JSON.stringify(InkBlob));
    document.getElementById('uploadFilename').innerHTML = InkBlob.filename;
  },
  function(FPError){
    console.log(FPError.toString());
  }
);
}
