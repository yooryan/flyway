/*
 * Copyright © Red Gate Software Ltd 2010-2021
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.database;

import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.extensibility.FlywayExtension;
import org.flywaydb.core.internal.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BigQueryDatabaseExtension implements FlywayExtension {
    public String getDescription() {
        return "GCP BigQuery database support (beta) " + readVersion() + " by Redgate\n" +
                "Join the GCP BigQuery beta via https://flywaydb.org/documentation/database/big-query#using-flyway-with-google-big-query";
    }

    private static String readVersion() {
        try {
            return FileCopyUtils.copyToString(
                    BigQueryDatabaseExtension.class.getClassLoader().getResourceAsStream("org/flywaydb/database/version.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FlywayException("Unable to read extension version: " + e.getMessage(), e);
        }
    }
}