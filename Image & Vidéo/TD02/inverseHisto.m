function out = inverseHisto(img)
  img(:,:,:) = 255 - img(:,:,:);
  out = img;
endfunction