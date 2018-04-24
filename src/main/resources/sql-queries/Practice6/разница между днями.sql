SELECT clients_services.date_activation, clients_services.date_deactivation,
    (TO_DAYS(clients_services.date_deactivation) - TO_DAYS(clients_services.date_activation)) as day_interval
FROM clients_services;