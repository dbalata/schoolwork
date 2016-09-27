% Dylan Balata
% CS 151 assingment 5
% Plotting data points for different water heights

clear
clc
close ALL

load prog5data.mat

figure(1) % Plots original data as points
plot(time,depth,'.')
xlabel('Time')
ylabel('Depth')
hold on

x = [time(1):(pi/50):time(end)]; % Plots initial cos curve
y = cos(x)
plot(x,y)

vert = 1/2 * (max(depth) + min(depth)); % Plots cos curve after vertical shift 
y = cos(x) + vert;
plot(x,y)

amp = (1/2) * (max(depth) - min(depth)) % Plots cos curve after vertical shift and amplitude change
y = amp * cos(x) + vert
plot(x,y)

[val_max,time_max] = max(depth) % Max/min values used in determining period and frequency
[val_min,time_min] = min(depth)

period = 2 * (time(time_max)-time(time_min)) % Plots cos curve after vertical shift, amplitude change, and frequency change
freq = (2*pi)/(period);
y = amp * cos(freq * x) + vert;
plot(x,y)

phase = time(time_max) % Plots cos curve after vertical shift, amplitude change, frequency change, and phase shift
y = amp * cos(freq * (x-phase)) + vert;
plot(x,y)

plot([0 12],[11,11]) % Plots horizontal line showing optimal crossing time

% The boat must travel between times 1 and 3; shown by the portion of the
% graph where the cos curve is above the horizontal line.