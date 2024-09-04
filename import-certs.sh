#!/bin/bash

# Variables
PEM_FILE="/tmp/certs/global-bundle.pem"
TRUSTSTORE="/tmp/certs/truststore.jks"
STOREPASS="changeit"

# Create a temporary directory to store individual certificates
TEMP_DIR=$(mktemp -d)

# Split the PEM file into individual certificates
csplit -z -f "$TEMP_DIR/cert" -b "%02d.pem" "$PEM_FILE" '/-----BEGIN CERTIFICATE-----/' '{*}'

# Function to check if the certificate contains "ca-central-1" in the owner field
contains_ca_central_1() {
    openssl x509 -in "$1" -noout -subject | grep -q "ca-central-1"
}

# Import each certificate into the truststore
for CERT in "$TEMP_DIR"/cert*.pem; do
  if contains_ca_central_1 "$CERT"; then
    ALIAS=$(basename "$CERT" .pem)
    keytool -importcert -trustcacerts -alias "$ALIAS" -file "$CERT" -keystore "$TRUSTSTORE" -storepass "$STOREPASS" -noprompt
  fi
done

# Clean up temporary directory
rm -rf "$TEMP_DIR"

echo "All certificates have been imported into the truststore."