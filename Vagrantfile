Vagrant.configure("2") do |config|
	config.vm.box = "ubuntu/bionic64"
	
	config.vm.define :db do |db_config|
		db_config.vm.network "private_network", ip: "192.168.50.11"
	end
	
	config.vm.define :web do |web_config|
		web_config.vm.network "private_network", ip: "192.168.50.10"
	end
end