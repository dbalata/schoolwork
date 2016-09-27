% Dylan Balata
% CS 151-005
% Assignment 6 Cos
% Determines cosine portion

function pt = cs151sp15assn6cos(amp,freq,hs,vs,startxdomain,endxdomain)
x = (startxdomain:.1:endxdomain); % x values of cosine curve
y = vs + amp .* cos(freq.*(x-hs)); % y values of cosine curve
plot(x,y,'k') % plots cosine curve
pt = [x(1),y(1)]; % point at the start of curve