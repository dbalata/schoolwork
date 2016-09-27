% Dylan Balata
% cs151sp15assn4
% Evaluating and plotting data

clear
clc
close ALL

load voltage % loads data

time = sensor(:,1); % seperates time values
s = sensor(:,2:end); % seperates sensor values

numsensors1 = (size(sensor)-1); % used to determine number of sensors
numsensors = numsensors1(2) % determines number of sensors

[maxval maxloc] = max(sensor); % max values and locations
[minval minloc] = min(sensor); % min values and locations

maxtime = time(maxloc)'; % max times
mintime = time(minloc)'; % min times

avgsensors = mean(s) % average from all sensors
avgall = mean(avgsensors)
row = s(:); % used to determine standard deviation
standarddev = std(row) % standard deviation of all sensors

max_val = (maxval(:,2:end)) % fixes max val to not include time
max_time = (maxtime(:,2:end)) 

min_val = (minval(:,2:end))
min_time = (mintime(:,2:end))

figure(1) % Plot of each sensor with corresponding average value
plot(1:numsensors,avgsensors,'o-')
title('Averages with Sensor Numbers')
xlabel('Sensor Number')
ylabel('Averages')
