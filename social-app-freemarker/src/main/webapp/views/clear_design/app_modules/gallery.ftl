<div class="masonry-gallery">
    <#list dto.user.images as image>
        <div id="image-${image.imageId}" class="masonry-thumb">
            <a title="Click to delete" href="#" onclick="deleteImage(${dto.user.userId}, ${image.imageId})">
                <img class="grayscale" src="${image.url}" alt="Image ${image.imageId}">
            </a>
        </div>
    <#else>
        <div>
        Gallery is Empty
        </div>
    </#list>
</div>

<form method="POST" action="gallery/upload?id=${dto.user.userId}" enctype="multipart/form-data">
    <input type="file" name="file">
    <div class="form-actions">
      <button type="submit" class="btn btn-primary">Upload</button>
      <button type="reset" class="btn">Cancel</button>
    </div>
</form>