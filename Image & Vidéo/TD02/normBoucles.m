function out = normBoucles (img)
[m,n,p] = size(img);
maxImage = max(img);
minImage = min(img);
diff = maxImage - minImage;
for i =1 : m
  for j = 1:n
    img(i,j,:) = (255./diff).*(img(i,j)-minImage);
  endfor
endfor
out = img;
endfunction