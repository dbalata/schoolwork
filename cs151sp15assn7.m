% Dylan Balata
% cs151sp15assn7
% volume of a tank


function f = cs151sp15assn7(hwater)

dtop = 54;
hupper = 19.8;
dbttm = 34.2;
hlower = 25.5;

z = find(hwater > (hlower+hupper)); % finding overflow values and displaying error
if length(z)>0
    disp('error: water overflow')
    return
end

j = find(hwater < 0); % finding negative height values and displaying error
if length(j)>0
    disp('error: negative height value')
    return
end

x = find(hwater <= hlower); % finding and printing values less than or equal to 25.5
fprintf('There are %.0f height values below or equal to 25.5\n', length(x))

if length(x)>0 % calculating and printing volume for heights less than or equal to 25.5
v1 = (pi.*(dbttm/2).^2).*hwater(x);
fprintf('Volume of water for height of %.2f: %.2f\n',[hwater(x);v1])
end

y = find(hwater > hlower); % finding and printing values greater to 25.5
fprintf('There are %.0f height values greater than 25.5\n', length(y))

if length(y)>0 % calculating and printing volume for heights greater than 25.5
radius = dbttm/2 + (1/2)*(hwater(y)-hlower);
v2 = pi.*(dbttm/2).^2.*hlower+(1/3).*pi.*(hwater(y)-hlower).*((dbttm/2).^2+(dbttm/2)*radius+radius.^2);
fprintf('Volume of water for height of %.2f: %.2f\n',[hwater(y);v2])
end

